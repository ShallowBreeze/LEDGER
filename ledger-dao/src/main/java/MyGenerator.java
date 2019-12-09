import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.FileType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

/**
 * @description: 自动生成代码
 * @author: pengzhen@cmhit.com
 * @create: 2019-12-03 15:21
 **/
public class MyGenerator {
    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void sss(String[] args) {
        String[] models = {"/ledger-dao","/ledger-service"};
        for (String model : models) {
//            shell(model);
        }
    }

    public static void main(String[] args) {


/*        File file = new File(model);
        String path = file.getAbsolutePath();*/
        Properties properties = new Properties();
        try {
            properties = PropertiesLoaderUtils.loadAllProperties("jdbc.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath +"/ledger-dao/src/main/java");
        gc.setFileOverride(true);
        gc.setActiveRecord(true);//不需要ActiveRecord特性的请改为false
        gc.setEnableCache(false);//XML二级缓存
        gc.setBaseResultMap(true);//XML ResultMap
        gc.setBaseColumnList(false);//XML columList
        gc.setAuthor("pz");//作者
        gc.setOpen(false);
        //设置日期类型为java.util
        gc.setDateType(DateType.ONLY_DATE);
//        实体属性 Swagger2 注解
        gc.setSwagger2(true);

        //自定义文件命名，注意%s 会自动填充表实体属性
        gc.setControllerName("%sController");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setMapperName("%sDao");
        gc.setXmlName("%sMapper");

        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setUrl(properties.getProperty("jdbc.url"));
        dsc.setDriverName(properties.getProperty("jdbc.driver"));
        // dsc.setSchemaName("public");
//        dsc.setDriverName(properties.getProperty("jdbc.driver"));
        dsc.setUsername(properties.getProperty("jdbc.username"));
        dsc.setPassword(properties.getProperty("jdbc.password"));
        mpg.setDataSource(dsc);


        //包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.ledger");
//        pc.setModuleName("sys");
        pc.setController("controller.sys");
        pc.setService("service.sys");
        pc.setServiceImpl("service.sys.impl");
        pc.setMapper("dao");
        pc.setEntity("entity");
        pc.setXml("xml");
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
        String mapperTemplatePath = "/templates/mapper.xml.ftl";
        //service 和controller放到service模块下
        String serviceTemplatePath = "/templates/service.java.ftl";
        String serviceImplTemplatePath = "/templates/serviceImpl.java.ftl";
        String controllerTemplatePath = "templates/controller2.java.ftl";
        // 如果模板引擎是 velocity
        // String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(mapperTemplatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/ledger-dao/src/main/resources/mapper/"
                        + "/" + tableInfo.getXmlName() + StringPool.DOT_XML;
    /*            return projectPath + "/ledger-log/src/main/resources/mapper"
                        + "/" + tableInfo.getXmlName()+ StringPool.DOT_XML;*/
            }
        });
        focList.add(new FileOutConfig(serviceTemplatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                String a=pc.getService().replace(".","/");
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/ledger-service/src/main/java/com/ledger/"+a
                        + "/" + tableInfo.getServiceName() + StringPool.DOT_JAVA;
            }
        });

        focList.add(new FileOutConfig(serviceImplTemplatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                String a =pc.getServiceImpl().replace(".","/");
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/ledger-service/src/main/java/com/ledger/"+a
                        + "/" + tableInfo.getServiceImplName()+ StringPool.DOT_JAVA;
            }
        });

        focList.add(new FileOutConfig(controllerTemplatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                String a=pc.getController().replace(".","/");
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/ledger-service/src/main/java/com/ledger/"+a
                        + "/" + tableInfo.getControllerName() + StringPool.DOT_JAVA;
            }
        });

/*        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建
                checkDir("调用默认方法创建的目录");
                return false;
            }
        });*/
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
         templateConfig.setEntity("templates/entity.java");
        // templateConfig.setService();
         templateConfig.setController("templates/controller2.java");
        //设置为空不自动生成，根据自定义配置生成
        templateConfig.setController(null);
        templateConfig.setService(null);
        templateConfig.setServiceImpl(null);
        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//        strategy.setSuperEntityClass("com.ledger.common.core.entity.BaseEntity");
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        //Controller驼峰转连字符"-"
        strategy.setControllerMappingHyphenStyle(false);
        //是否生成实体时，生成字段注解
        strategy.setEntityTableFieldAnnotationEnable(true);
        //实体类为Build模型
//        strategy.setEntityBuilderModel(true);
        // 公共父类
//        strategy.setSuperControllerClass("com.baomidou.ant.common.BaseController");
        strategy.setSuperServiceClass("com.ledger.common.core.service.IBaseService");
        strategy.setSuperServiceImplClass("com.ledger.common.core.service.impl.BaseService");
        // 写于父类中的公共字段
//        strategy.setSuperEntityColumns("id");
//        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        //表名，多个英文逗号分割
//       strategy.setInclude(new String[]{"t_sys_log"});
        strategy.setExclude("t_sys_log");
        strategy.setTablePrefix( "t_sys_","_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }
}
