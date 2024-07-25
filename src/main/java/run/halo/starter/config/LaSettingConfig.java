package run.halo.starter.config;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class LaSettingConfig {

    public static final String CONFIG_MAP_NAME = "plugin-tongji-config";
    public static final String GROUP = "51la";

    /**
     * 启用51LA统计
     */
    private Boolean enableLA;

    /**
     * 登录用户名
     */
    private String username;

    /**
     * 登录用户密码
     */
    private String password;

}
