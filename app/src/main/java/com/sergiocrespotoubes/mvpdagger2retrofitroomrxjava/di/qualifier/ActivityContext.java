
package com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.di.qualifier;

import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.CLASS;

/**
 * Injections of {@link android.content.Context} annotated with this annotation will inject the
 * current Activity context.
 */
@Qualifier
@Retention(CLASS)
public @interface ActivityContext {
}