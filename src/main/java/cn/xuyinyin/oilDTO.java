package cn.xuyinyin;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author XuJiaWei
 * @since 2022-08-31 18:12
 */
@NoArgsConstructor
@Data
public class oilDTO {

    @JsonProperty("status")
    private Integer status;
    @JsonProperty("data")
    private DataDTO data;
    @JsonProperty("msg")
    private String msg;

    @NoArgsConstructor
    @Data
    public static class DataDTO {
        @JsonProperty("price_info")
        private List<PriceInfoDTO> priceInfo;
        @JsonProperty("effective_time")
        private String effectiveTime;
        @JsonProperty("next_adjustment_time")
        private NextAdjustmentTimeDTO nextAdjustmentTime;
        @JsonProperty("top_tips")
        private String topTips;
        @JsonProperty("adjust_info_text")
        private String adjustInfoText;

        @NoArgsConstructor
        @Data
        public static class NextAdjustmentTimeDTO {
            @JsonProperty("year")
            private Integer year;
            @JsonProperty("month")
            private Integer month;
            @JsonProperty("day")
            private Integer day;
            @JsonProperty("hour")
            private Integer hour;
            @JsonProperty("minute")
            private Integer minute;
        }

        @NoArgsConstructor
        @Data
        public static class PriceInfoDTO {
            @JsonProperty("name")
            private String name;
            @JsonProperty("price")
            private String price;
        }
    }
}
