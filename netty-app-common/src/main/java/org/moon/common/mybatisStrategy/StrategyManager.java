package org.moon.common.mybatisStrategy;



import org.moon.common.mybatisStrategy.strategy.Strategy;
import org.moon.common.mybatisStrategy.strategy.impl.HashIDStrategy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @author YCKJ3275
 */
public class StrategyManager {
    //策略名称
    public static final String _YYYYMM01 = "YYYYMM01";

    public static final String _YYYYMMDD = "YYYYMMDD";

    public static final String _YYYYMM = "YYYYMM";

    public static final String HASHID = "HASHID";

    private Map<String, Strategy> strategies = new ConcurrentHashMap<String, Strategy>(10);

    /**
     * 向管理器中添加策略
     * @param strategyName
     * @param strategy
     */
    public void addStrategy(String strategyName, HashIDStrategy strategy) {
        strategies.put(strategyName, (Strategy) strategy);
    }

    public  Strategy getStrategy(String key){
        return strategies.get(key);
    }

    public Map<String, Strategy> getStrategies() {
        return strategies;
    }

    public void setStrategies(Map<String, String> strategies) {
        for(Map.Entry<String, String> entry : strategies.entrySet()){
            try {
                this.strategies.put(entry.getKey(),(Strategy)Class.forName(entry.getValue()).newInstance());
            } catch (Exception e) {
                System.out.println("实例化策略出错"+e);
            }
        }
    }

}

