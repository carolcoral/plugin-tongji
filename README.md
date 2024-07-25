# plugin-starter

> Halo 2.0 访问统计插件

* 代码仓库: [plugin-tongji](https://github.com/carolcoral/plugin-tongji)
* 如果你也喜欢该插件，可以通过 [爱发电](https://afdian.net/a/carolcoral) 或下面赞赏码对我进行支持～～
* 更多内容查看 [插件文档](https://blog.xindu.site/docs/plugin-tongji)

## 使用方式
1. 启动插件
2. 在插件配置中填写自己的账号登陆

## 支持我

| ![weixin](https://redirect.cnkj.site:8099/b/2024/665de1eeaf4a4.webp?type=blog) | ![zhifubao](https://redirect.cnkj.site:8099/b/2024/665de1cda2c05.webp?type=blog) |
|:------------------------|:----------------------------|

## 开发环境

插件开发的详细文档请查阅：<https://docs.halo.run/developer-guide/plugin/introduction>

所需环境：

1. Java 17
2. Node 20
3. pnpm 9
4. Docker (可选)

克隆项目：

```bash
git clone git@github.com:carolcoral/plugin-tongji.git

# 或者当你 fork 之后

git clone git@github.com:{your_github_id}/plugin-starter.git
```

```bash
cd path/to/plugin-tongji
```

### 运行方式 1（推荐）

> 此方式需要本地安装 Docker

```bash
# macOS / Linux
./gradlew pnpmInstall

# Windows
./gradlew.bat pnpmInstall
```

```bash
# macOS / Linux
./gradlew haloServer

# Windows
./gradlew.bat haloServer
```

执行此命令后，会自动创建一个 Halo 的 Docker 容器并加载当前的插件，更多文档可查阅：<https://docs.halo.run/developer-guide/plugin/basics/devtools>

### 运行方式 2

> 此方式需要使用源码运行 Halo

编译插件：

```bash
# macOS / Linux
./gradlew build

# Windows
./gradlew.bat build
```

修改 Halo 配置文件：

```yaml
halo:
  plugin:
    runtime-mode: development
    fixedPluginPath:
      - "/path/to/plugin-starter"
```

最后重启 Halo 项目即可。
