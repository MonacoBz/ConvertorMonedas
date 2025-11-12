import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

public record JsonDto(
        @SerializedName("base_code")
        String monedaOriginal,
        @SerializedName("target_code")
        String monedaObjetivo,
        @SerializedName("conversion_result")
        BigDecimal resultado

) {
}
