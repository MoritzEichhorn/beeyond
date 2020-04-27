package at.htl.beeyond.service;

import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.vertx.core.json.JsonObject;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import javax.enterprise.context.ApplicationScoped;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

@ApplicationScoped
public class NamespaceService {

    private Yaml yaml;
    private KubernetesClient client;

    public NamespaceService() {
        DumperOptions dumperOptions = new DumperOptions();
        dumperOptions.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
        dumperOptions.setPrettyFlow(true);

        this.yaml = new Yaml(dumperOptions);
        this.client = new DefaultKubernetesClient();
    }

    private List<JsonObject> readYaml(String file) {
        List<JsonObject> result = new LinkedList<>();

        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream("/config-templates/" + file);
        Iterable<Object> objects = this.yaml.loadAll(inputStream);

        for (Object object : objects) {
            result.add(JsonObject.mapFrom(object));
        }

        return result;
    }
}
