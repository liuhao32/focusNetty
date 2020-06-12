package org.moon.common.config;

import org.moon.common.mybatisStrategy.StrategyManager;
import org.moon.common.mybatisStrategy.strategy.impl.HashIDStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 分表策略管理类
 * @author YCKJ3275
 */
@Configuration
public class StrategyConfig {

	/**
	 * 策略配置类
	 * @return StrategyManager
	 */
	@Bean
	public StrategyManager strategyManager() {
		StrategyManager strategyManager = new StrategyManager();
		strategyManager.addStrategy(StrategyManager.HASHID, new HashIDStrategy());
		return strategyManager;
	}
	
}
