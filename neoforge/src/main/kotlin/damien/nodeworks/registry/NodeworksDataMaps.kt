package damien.nodeworks.registry

import damien.nodeworks.script.cpu.CoolantRating
import net.minecraft.core.registries.Registries
import net.minecraft.resources.Identifier
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.state.BlockState
import net.neoforged.neoforge.registries.datamaps.DataMapType
import net.neoforged.neoforge.registries.datamaps.RegisterDataMapTypesEvent

object NodeworksDataMaps {
    val COOLANT: DataMapType<Block, CoolantRating> = DataMapType.builder(
        Identifier.fromNamespaceAndPath("nodeworks", "coolant"),
        Registries.BLOCK,
        CoolantRating.CODEC,
    ).build()

    fun register(event: RegisterDataMapTypesEvent) {
        event.register(COOLANT)
    }

    fun coolantRating(state: BlockState): CoolantRating? =
        state.block.builtInRegistryHolder().getData(COOLANT)
}
