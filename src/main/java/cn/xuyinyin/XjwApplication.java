package cn.xuyinyin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import cn.xuyinyin.oilDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

/**
 * 启动类
 * @author xjw
 */
@RestController
@SpringBootApplication
public class XjwApplication {

    public static void main(String[] args) {
        SpringApplication.run(XjwApplication.class, args);
    }

    public static final String url = "https://open.yiwenzaixian.com/cheyixun/oil_price/getCurrentOilPriceInfo?from=mini_program&province=%E5%B9%BF%E4%B8%9C%E7%9C%81&city=%E5%B9%BF%E5%B7%9E%E5%B8%82&miniprogram_brand=MacBookPro15%2C2&miniprogram_model=MacBookPro15%2C2&miniprogram_system=macOS%2012.5.1&miniprogram_platform=mac&miniprogram_wechat_version=3.5.5&miniprogram_SDKversion=2.18.1&miniprogram_version=0.0.18&miniprogram_envVersion=release";


    @GetMapping
    public String test() throws JsonProcessingException {
        String json = httpGet(url);
        ObjectMapper objectMapper = new ObjectMapper();
        oilDTO oilDTO = objectMapper.readValue(json, oilDTO.class);
        System.out.println(oilDTO.getData().getPriceInfo().get(0).getPrice());
        return "当前92#的油价为" + oilDTO.getData().getPriceInfo().get(0).getPrice() + "/L";
    }

    private static String httpGet(String url) {
        String result = "";
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        CloseableHttpResponse response = null;
        try {
            HttpGet request = new HttpGet(url);
            response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                result = EntityUtils.toString(entity);
                System.out.println(result);
            }
            EntityUtils.consume(entity);
        } catch (Exception e) {
            System.out.println("Exception when sending http request to ali monitor");
        } finally {
            try {
                if (response != null)
                    response.close();
                httpClient.close();
            } catch (Exception e) {
                System.out.println("Exception when closing httpclient");
            }
        }
        return result;
    }
}
