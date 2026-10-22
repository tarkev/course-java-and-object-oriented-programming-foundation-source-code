// Generated from modules/09-file-handling-and-i-o/07-designing-a-file-based-repository.md by tools/extract_code.py. Edit the lesson, not this file.
package module09.lesson07.example01.repository;

import module09.lesson07.example01.course.Course;
import module09.lesson07.example01.course.CourseCode;
import module09.lesson07.example01.course.CourseStatus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.AtomicMoveNotSupportedException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Properties;
import java.util.stream.Stream;

public final class FileCourseRepository
        implements CourseRepository {

    private final Path baseDirectory;

    public FileCourseRepository(
            Path baseDirectory
    ) {
        if (
                baseDirectory == null
        ) {
            throw new IllegalArgumentException(
                    "Base directory is required."
            );
        }

        this.baseDirectory =
                baseDirectory
                        .toAbsolutePath()
                        .normalize();
    }

    @Override
    public void save(
            Course course
    ) {
        if (
                course == null
        ) {
            throw new IllegalArgumentException(
                    "Course is required."
            );
        }

        Path target =
                resolveFile(
                        course.getCode()
                );

        try {
            Files.createDirectories(
                    baseDirectory
            );

            replaceFile(
                    target,
                    serialize(
                            course
                    )
            );
        } catch (
                IOException exception
        ) {
            throw new CourseRepositoryException(
                    "Could not save course "
                            + course.getCode()
                            + ".",
                    exception
            );
        }
    }

    @Override
    public Course findByCode(
            CourseCode courseCode
    ) {
        Path path =
                resolveFile(
                        courseCode
                );

        try {
            return deserialize(
                    loadProperties(
                            path
                    ),
                    path
            );
        } catch (
                NoSuchFileException exception
        ) {
            return null;
        } catch (
                IOException exception
        ) {
            throw new CourseRepositoryException(
                    "Could not load course "
                            + courseCode
                            + ".",
                    exception
            );
        }
    }

    @Override
    public List<Course> findAll() {
        try {
            Files.createDirectories(
                    baseDirectory
            );
        } catch (
                IOException exception
        ) {
            throw new CourseRepositoryException(
                    "Could not initialize course repository.",
                    exception
            );
        }

        try (
                Stream<Path> paths =
                        Files.list(
                                baseDirectory
                        )
        ) {
            return paths.filter(
                    Files::isRegularFile
            )
            .filter(
                    this::isCourseFile
            )
            .map(
                    this::loadCourseFile
            )
            .toList();
        } catch (
                IOException exception
        ) {
            throw new CourseRepositoryException(
                    "Could not list courses.",
                    exception
            );
        }
    }

    @Override
    public boolean deleteByCode(
            CourseCode courseCode
    ) {
        Path path =
                resolveFile(
                        courseCode
                );

        try {
            return Files.deleteIfExists(
                    path
            );
        } catch (
                IOException exception
        ) {
            throw new CourseRepositoryException(
                    "Could not delete course "
                            + courseCode
                            + ".",
                    exception
            );
        }
    }

    private Path resolveFile(
            CourseCode courseCode
    ) {
        if (
                courseCode == null
        ) {
            throw new IllegalArgumentException(
                    "Course code is required."
            );
        }

        String fileName =
                courseCode.getValue()
                        .toLowerCase()
                        + ".properties";

        Path target =
                baseDirectory
                        .resolve(
                                fileName
                        )
                        .normalize();

        if (
                !target.startsWith(
                        baseDirectory
                )
        ) {
            throw new IllegalArgumentException(
                    "Course path escapes repository directory."
            );
        }

        return target;
    }

    private Properties serialize(
            Course course
    ) {
        Properties properties =
                new Properties();

        properties.setProperty(
                "code",
                course.getCode()
                        .getValue()
        );

        properties.setProperty(
                "title",
                course.getTitle()
        );

        properties.setProperty(
                "priceInPaisa",
                Long.toString(
                        course.getPriceInPaisa()
                )
        );

        properties.setProperty(
                "status",
                course.getStatus()
                        .name()
        );

        return properties;
    }

    private Course deserialize(
            Properties properties,
            Path source
    ) {
        try {
            CourseCode code =
                    new CourseCode(
                            requireProperty(
                                    properties,
                                    "code"
                            )
                    );

            String title =
                    requireProperty(
                            properties,
                            "title"
                    );

            long priceInPaisa =
                    Long.parseLong(
                            requireProperty(
                                    properties,
                                    "priceInPaisa"
                            )
                    );

            CourseStatus status =
                    CourseStatus.valueOf(
                            requireProperty(
                                    properties,
                                    "status"
                            )
                    );

            return Course.restore(
                    code,
                    title,
                    priceInPaisa,
                    status
            );
        } catch (
                CourseRepositoryException exception
        ) {
            throw exception;
        } catch (
                RuntimeException exception
        ) {
            throw new CourseRepositoryException(
                    "Stored course data is invalid: "
                            + source.getFileName()
                            + ".",
                    exception
            );
        }
    }

    private String requireProperty(
            Properties properties,
            String key
    ) {
        String value =
                properties.getProperty(
                        key
                );

        if (
                value == null
                || value.isBlank()
        ) {
            throw new CourseRepositoryException(
                    "Stored course is missing property: "
                            + key
                            + "."
            );
        }

        return value;
    }

    private Properties loadProperties(
            Path path
    ) throws IOException {
        Properties properties =
                new Properties();

        try (
                BufferedReader reader =
                        Files.newBufferedReader(
                                path,
                                StandardCharsets.UTF_8
                        )
        ) {
            properties.load(
                    reader
            );
        }

        return properties;
    }

    private void storeProperties(
            Path path,
            Properties properties
    ) throws IOException {
        try (
                BufferedWriter writer =
                        Files.newBufferedWriter(
                                path,
                                StandardCharsets.UTF_8
                        )
        ) {
            properties.store(
                    writer,
                    null
            );
        }
    }

    private void replaceFile(
            Path target,
            Properties properties
    ) throws IOException {
        Path temp =
                Files.createTempFile(
                        baseDirectory,
                        "course-",
                        ".tmp"
                );

        try {
            storeProperties(
                    temp,
                    properties
            );

            try {
                Files.move(
                        temp,
                        target,
                        StandardCopyOption.REPLACE_EXISTING,
                        StandardCopyOption.ATOMIC_MOVE
                );
            } catch (
                    AtomicMoveNotSupportedException exception
            ) {
                Files.move(
                        temp,
                        target,
                        StandardCopyOption.REPLACE_EXISTING
                );
            }
        } finally {
            Files.deleteIfExists(
                    temp
            );
        }
    }

    private boolean isCourseFile(
            Path path
    ) {
        return path.getFileName()
                .toString()
                .endsWith(
                        ".properties"
                );
    }

    private Course loadCourseFile(
            Path path
    ) {
        try {
            return deserialize(
                    loadProperties(
                            path
                    ),
                    path
            );
        } catch (
                IOException exception
        ) {
            throw new CourseRepositoryException(
                    "Could not load stored course "
                            + path.getFileName()
                            + ".",
                    exception
            );
        }
    }
}
