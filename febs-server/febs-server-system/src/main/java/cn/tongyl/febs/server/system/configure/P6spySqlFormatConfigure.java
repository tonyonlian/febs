package cn.tongyl.febs.server.system.configure;

import cn.tongyl.febs.common.utils.DateUtil;
import com.p6spy.engine.spy.appender.MessageFormattingStrategy;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

/**
 * 自定义sql打印日志
 *
 * @author create by Tunyl on 2021/9/4
 * @version 1.0
 */
@Configuration
public class P6spySqlFormatConfigure implements MessageFormattingStrategy {
    @Override
    public String formatMessage(int connectionId, String now, long elapsed, String category, String prepared, String sql, String url) {


        return StringUtils.isNotBlank(sql) ? DateUtil.formatFullTime(LocalDateTime.now(), DateUtil.FULL_TIME_SPLIT_PATTERN)
                + " | 耗时 " + elapsed
                + " ms | SQL 语句 " + StringUtils.LF
                + sql.replaceAll("[\\s]+", StringUtils.SPACE)
                + ";" : StringUtils.EMPTY;
    }
}
