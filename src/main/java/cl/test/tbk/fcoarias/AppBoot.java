package cl.test.tbk.fcoarias;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableAutoConfiguration
@EnableSwagger2
@ComponentScan({ "cl.test.tbk.fcoarias.controller", "cl.test.tbk.fcoarias.service",  "cl.test.tbk.fcoarias.dao" })
public class AppBoot implements CommandLineRunner{


	private EmbeddedDatabase db;
	private static final Logger logger = LoggerFactory.getLogger(AppBoot.class);

	
	@Bean
	public ObjectMapper jsonObjectMapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return mapper;
	}
	
	@Override
	public void run(String... args) throws Exception {
		logger.info("TEST - TRANSBANK - FCOARIAS...");

		logger.info("Creando base de datos en memoria HSQL....");
		logger.info("Generando datasource.....");
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		db = builder.setType(EmbeddedDatabaseType.HSQL).addScript("classpath:table.sql").build();
		
		if (db!=null && db.getConnection()!=null && db.getConnection().getMetaData()!=null) {
			logger.info("URL Conexion :"+db.getConnection().getMetaData().getURL());
			logger.info("Conecction user:"+db.getConnection().getMetaData().getUserName());
		}else
			logger.warn("NO existe informacion de conexion de DB....");
		
		logger.info("Inicializacion servicio de forma exitosa...");
		
		
	}
	
	public static void main(String[] args) {
		SpringApplication.run(AppBoot.class, args);
	}
	
	

}
