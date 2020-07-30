package one.xingyi.datakata;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileLinesSource {
    //Should we have a separate streamer for the football/weather?
    static public Stream<String> stream(String resourceName) {
        try {
            URL resource = FileLinesSource.class.getClassLoader().getResource(resourceName);
            if (resource==null) throw new RuntimeException("Cannot load " + resourceName);
            return Files.lines(Paths.get(resource.toURI())).
                    skip(1).
                    filter(s -> !s.trim().startsWith("-")).
                    filter(s -> !s.isEmpty()).
                    filter(s->!s.trim().startsWith("mo"))
                    ;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
