package net.theblindbandit6.seasonaladditions.block.custom;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import net.minecraft.block.*;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.function.Function;

//TODO Fix fairy lights

public class FairyLightsBlock extends Block{
    private static final float field_31194 = 1.0F;
    private static final VoxelShape UP_SHAPE = Block.createCuboidShape(0.0, 15.0, 10.0, 16.0, 16.0, 15.0);
    private static final VoxelShape DOWN_SHAPE = Block.createCuboidShape(0.0, 0.0, 1.0, 16.0, 1.0, 6.0);
    private static final VoxelShape EAST_SHAPE = Block.createCuboidShape(0.0, 10.0, 0.0, 1.0, 15.0, 16.0);
    private static final VoxelShape WEST_SHAPE = Block.createCuboidShape(15.0, 10.0, 0.0, 16.0, 15.0, 16.0);
    private static final VoxelShape SOUTH_SHAPE = Block.createCuboidShape(0.0, 10.0, 0.0, 16.0, 15.0, 1.0);
    private static final VoxelShape NORTH_SHAPE = Block.createCuboidShape(0.0, 10.0, 15.0, 16.0, 15.0, 16.0);
    private static final Map<Direction, BooleanProperty> FACING_PROPERTIES = ConnectingBlock.FACING_PROPERTIES;
    private static final Map<Direction, VoxelShape> SHAPES_FOR_DIRECTIONS = Util.make(Maps.newEnumMap(Direction.class), shapes -> {
        shapes.put(Direction.NORTH, SOUTH_SHAPE);
        shapes.put(Direction.EAST, WEST_SHAPE);
        shapes.put(Direction.SOUTH, NORTH_SHAPE);
        shapes.put(Direction.WEST, EAST_SHAPE);
        shapes.put(Direction.UP, UP_SHAPE);
        shapes.put(Direction.DOWN, DOWN_SHAPE);
    });
    protected static final Direction[] DIRECTIONS = Direction.values();
    private final ImmutableMap<BlockState, VoxelShape> SHAPES;
    private final boolean hasAllHorizontalDirections;
    private final boolean canMirrorX;
    private final boolean canMirrorZ;

    public FairyLightsBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState(withAllDirections(this.stateManager));
        this.SHAPES = this.getShapesForStates(FairyLightsBlock::getShapeForState);
        this.hasAllHorizontalDirections = Direction.Type.HORIZONTAL.stream().allMatch(this::canHaveDirection);
        this.canMirrorX = Direction.Type.HORIZONTAL.stream().filter(Direction.Axis.X).filter(this::canHaveDirection).count() % 2L == 0L;
        this.canMirrorZ = Direction.Type.HORIZONTAL.stream().filter(Direction.Axis.Z).filter(this::canHaveDirection).count() % 2L == 0L;
    }

    protected boolean canHaveDirection(Direction direction) {
        return true;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        for (Direction direction : DIRECTIONS) {
            if (!this.canHaveDirection(direction)) continue;
            builder.add(MultifaceGrowthBlock.getProperty(direction));
        }
    }

    @Override
    protected BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (!FairyLightsBlock.hasAnyDirection(state)) {
            return Blocks.AIR.getDefaultState();
        }
        if (!MultifaceGrowthBlock.hasDirection(state, direction) || MultifaceGrowthBlock.canGrowOn(world, direction, neighborPos, neighborState)) {
            return state;
        }
        return FairyLightsBlock.disableDirection(state, MultifaceGrowthBlock.getProperty(direction));
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return this.SHAPES.get(state);
    }

    @Override
    protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        boolean bl = false;
        for (Direction direction : DIRECTIONS) {
            if (!MultifaceGrowthBlock.hasDirection(state, direction)) continue;
            BlockPos blockPos = pos.offset(direction);
            if (!MultifaceGrowthBlock.canGrowOn(world, direction, blockPos, world.getBlockState(blockPos))) {
                return false;
            }
            bl = true;
        }
        return bl;
    }

    @Override
    protected boolean canReplace(BlockState state, ItemPlacementContext context) {
        return FairyLightsBlock.isNotFullBlock(state);
    }

    @Override
    @Nullable
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        World world = ctx.getWorld();
        BlockPos blockPos = ctx.getBlockPos();
        BlockState blockState = world.getBlockState(blockPos);
        return Arrays.stream(ctx.getPlacementDirections()).map(direction -> this.withDirection(blockState, world, blockPos, (Direction)direction)).filter(Objects::nonNull).findFirst().orElse(null);
    }

    public boolean canGrowWithDirection(BlockView world, BlockState state, BlockPos pos, Direction direction) {
        if (!this.canHaveDirection(direction) || state.isOf(this) && MultifaceGrowthBlock.hasDirection(state, direction)) {
            return false;
        }
        BlockPos blockPos = pos.offset(direction);
        return MultifaceGrowthBlock.canGrowOn(world, direction, blockPos, world.getBlockState(blockPos));
    }

    @Nullable
    public BlockState withDirection(BlockState state, BlockView world, BlockPos pos, Direction direction) {
        if (!this.canGrowWithDirection(world, state, pos, direction)) {
            return null;
        }
        BlockState blockState = state.isOf(this) ? state : (this.isWaterlogged() && state.getFluidState().isEqualAndStill(Fluids.WATER) ? (BlockState)this.getDefaultState().with(Properties.WATERLOGGED, true) : this.getDefaultState());
        return (BlockState)blockState.with(MultifaceGrowthBlock.getProperty(direction), true);
    }

    @Override
    protected BlockState rotate(BlockState state, BlockRotation rotation) {
        if (!this.hasAllHorizontalDirections) {
            return state;
        }
        return this.mirror(state, rotation::rotate);
    }

    @Override
    protected BlockState mirror(BlockState state, BlockMirror mirror) {
        if (mirror == BlockMirror.FRONT_BACK && !this.canMirrorX) {
            return state;
        }
        if (mirror == BlockMirror.LEFT_RIGHT && !this.canMirrorZ) {
            return state;
        }
        return this.mirror(state, mirror::apply);
    }

    private BlockState mirror(BlockState state, Function<Direction, Direction> mirror) {
        BlockState blockState = state;
        for (Direction direction : DIRECTIONS) {
            if (!this.canHaveDirection(direction)) continue;
            blockState = (BlockState)blockState.with(MultifaceGrowthBlock.getProperty(mirror.apply(direction)), state.get(MultifaceGrowthBlock.getProperty(direction)));
        }
        return blockState;
    }

    private boolean isWaterlogged() {
        return this.stateManager.getProperties().contains(Properties.WATERLOGGED);
    }

    private static BlockState disableDirection(BlockState state, BooleanProperty direction) {
        BlockState blockState = (BlockState)state.with(direction, false);
        if (FairyLightsBlock.hasAnyDirection(blockState)) {
            return blockState;
        }
        return Blocks.AIR.getDefaultState();
    }

    private static BlockState withAllDirections(StateManager<Block, BlockState> stateManager) {
        BlockState blockState = stateManager.getDefaultState();
        for (BooleanProperty booleanProperty : FACING_PROPERTIES.values()) {
            if (!blockState.contains(booleanProperty)) continue;
            blockState = (BlockState)blockState.with(booleanProperty, false);
        }
        return blockState;
    }

    private static VoxelShape getShapeForState(BlockState state) {
        VoxelShape voxelShape = VoxelShapes.empty();
        for (Direction direction : DIRECTIONS) {
            if (!MultifaceGrowthBlock.hasDirection(state, direction)) continue;
            voxelShape = VoxelShapes.union(voxelShape, SHAPES_FOR_DIRECTIONS.get(direction));
        }
        return voxelShape.isEmpty() ? VoxelShapes.fullCube() : voxelShape;
    }

    protected static boolean hasAnyDirection(BlockState state) {
        return Arrays.stream(DIRECTIONS).anyMatch(direction -> MultifaceGrowthBlock.hasDirection(state, direction));
    }

    private static boolean isNotFullBlock(BlockState state) {
        return Arrays.stream(DIRECTIONS).anyMatch(direction -> !MultifaceGrowthBlock.hasDirection(state, direction));
    }
}
