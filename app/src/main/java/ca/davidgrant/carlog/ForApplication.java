package ca.davidgrant.carlog;

import java.lang.annotation.Retention;

import javax.inject.Qualifier;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by david on 08/02/15.
 */
@Qualifier
@Retention(RUNTIME)
public @interface ForApplication {
}