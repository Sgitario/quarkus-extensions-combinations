package quarkus.extensions.combinator.maven;

import java.io.File;

import quarkus.extensions.combinator.utils.FileUtils;

public class MavenProject extends MavenCommand {

    private static final String VERIFY = "verify";
    private static final String CLEAN = "clean";
    private static final String RANDOM_PORT_FOR_TESTS = "-Dquarkus.http.test-port=0";

    protected MavenProject(String artifactId, File workingDirectory) {
        super(artifactId, workingDirectory);
    }

    public MavenProject verify() {
        runMavenCommand(VERIFY, RANDOM_PORT_FOR_TESTS);
        return this;
    }

    public MavenProject clean() {
        runMavenCommand(CLEAN);
        return this;
    }

    public void delete() {
        FileUtils.deleteDirectory(getWorkingDirectory());
        FileUtils.deleteFile(getOutput());
    }

}
