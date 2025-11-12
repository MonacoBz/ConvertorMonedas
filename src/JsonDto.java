import com.google.gson.annotations.SerializedName;

public record JsonDto(
        String result,
        @SerializedName("base_code")
        String monedaOriginal,
        @SerializedName("target_code")
        String monedaObjetivo,
        @SerializedName("conversion_result")
        Integer resultado

) {
}
