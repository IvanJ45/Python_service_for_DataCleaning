package com.inserter.hive;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class HiveService {

    public void insertDataInHiveFromFile(MultipartFile multipartFile){

    }

    void executeSqlQuery(String url, String password, String username, int numberOfObjects) throws JsonProcessingException {
        HikariConfig config = getHikariConfig(url, password, username);
        HikariDataSource dataSource = new HikariDataSource(config);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "INSERT INTO my_schema.my_table (property1, property2, property3, property4, property5, property6, property7, property8, property9, property10) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        List<Object[]> batchArgs = new ArrayList<>();
        for (int i = 0; i < data.size(); i += BATCH_SIZE) {
            List<CsvDataModel> batchData = data.subList(i, Math.min(i + BATCH_SIZE, data.size()));

            jdbcTemplate.batchUpdate(insertSql, batchData, BATCH_SIZE,
                    (ps, model) -> {
                        ps.setString(1, model.getDateTime());
                        ps.setLong(2, model.getPlantId());
                        ps.setDouble(3, model.getDcPower());
                        ps.setDouble(4, model.getAcPower());
                        ps.setDouble(5, model.getDailyYield());
                        ps.setLong(6, model.getTotalYield());
                        ps.setInt(7, model.getTimeGap());
                        ps.setDouble(8, model.getAmbientTemperature());
                        ps.setDouble(9, model.getModuleTemperature());
                        ps.setDouble(10, model.getIrradiation());
                        ps.setInt(11, model.getHour());
                        ps.setInt(12, model.getDay());
                        ps.setInt(13, model.getDayOfWeek());
                        ps.setInt(14, model.getMinutes15());
                        ps.setString(15, model.getInverter());
                    });
        }

        jdbcTemplate.batchUpdate(sql, batchArgs);
        dataSource.close();
    }

    private HikariConfig getHikariConfig(String url, String password, String username) {
        HikariConfig config = new HikariConfig();
        config.setMaximumPoolSize(1);
        config.setJdbcUrl(url);
        config.setUsername(username);
        config.setPassword(password);
        return config;
    }

}
