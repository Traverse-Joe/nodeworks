package damien.nodeworks.script.cpu

import com.mojang.serialization.Codec
import com.mojang.serialization.codecs.RecordCodecBuilder

data class CoolantRating(val baseCooling: Float, val clusterBonus: Float) {
    companion object {
        private val NON_NEGATIVE: Codec<Float> = Codec.floatRange(0f, Float.MAX_VALUE)

        val CODEC: Codec<CoolantRating> = RecordCodecBuilder.create { inst ->
            inst.group(
                NON_NEGATIVE.fieldOf("base_cooling").forGetter(CoolantRating::baseCooling),
                NON_NEGATIVE.optionalFieldOf("cluster_bonus", 0f).forGetter(CoolantRating::clusterBonus),
            ).apply(inst, ::CoolantRating)
        }
    }
}
