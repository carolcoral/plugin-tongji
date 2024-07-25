package run.halo.starter.config;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class BaiduSettingConfig {

    public static final String CONFIG_MAP_NAME = "plugin-tongji-config";
    public static final String GROUP = "baidu";

    /**
     * 启用百度统计
     */
    private Boolean enableBaidu;

    /**
     * 登录用户名
     */
    private String username;

    /**
     * 登录用户密码
     */
    private String password;

}
