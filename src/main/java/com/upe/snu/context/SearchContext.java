package com.upe.snu.context;

import com.upe.snu.jpa.search.entity.Livro;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.node.NodeBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.net.InetAddress;

/**
 * Created by Max Guenes on 01/12/2016.
 */
@Configuration
@EnableElasticsearchRepositories(basePackages = "com.upe.snu.jpa.search.repository",
        elasticsearchTemplateRef = "elasticsearchTemplate")
@Order(3)
public class SearchContext  {

    @Autowired
    private Environment env;

    @Bean
    public NodeBuilder nodeBuilder() {
        return new NodeBuilder();
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() {
        Settings.Builder elasticsearchSettings =
                Settings.settingsBuilder()
                        .put("http.enabled", "false") // 1
                        .put("path.data", "./local_data") // 2
                        .put("path.home", env.getRequiredProperty("elasticsearch.path.home")); // 3

        ElasticsearchOperations template= new ElasticsearchTemplate(nodeBuilder()
                .local(true)
                .settings(elasticsearchSettings.build())
                .node()
                .client());

        template.putMapping(Livro.class);

        return template;
    }
}