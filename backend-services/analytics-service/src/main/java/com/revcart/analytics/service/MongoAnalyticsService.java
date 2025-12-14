package com.revcart.analytics.service;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class MongoAnalyticsService {

    public Map<String, Object> getAnalyticsSummary() {
        Map<String, Object> summary = new HashMap<>();
        summary.put("message", "Analytics service placeholder");
        return summary;
    }
}
