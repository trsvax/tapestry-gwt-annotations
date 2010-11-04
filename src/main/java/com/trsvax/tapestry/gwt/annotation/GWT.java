package com.trsvax.tapestry.gwt.annotation;

/**
 * This annotation has several targets and purposes:
 * 
 * - At class level it marks a class to be a GWT component. 
 * 		Three parameters can be used to specify which GWT Module is used,
 * 		and what it the human friendly type of the component.
 * - At method level it augments the Tapestry Component Event Handler methods and allows to
 * 		modify the event bubbling mechanism
 * - At the field level it marks the Tapestry Component Parameters used to initialize the
 * 		GWT component
 *  @author alessiogambi
 *  @author trsvax
 */

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.google.gwt.core.client.EntryPoint;

@Target({ TYPE, METHOD, FIELD })
@Retention(RUNTIME)
@Documented
public @interface GWT {

	/**
	 * The Class implementing the GWT EntryPoint.
	 * 
	 * This parameter is applicable at the class level
	 */
	Class<? extends EntryPoint> entryPoint() default EntryPoint.class;

	/**
	 * Override for the entry point to identify the EntryPoint. If this is not
	 * specified the entryPoint() value will be used.
	 * 
	 * This parameter is applicable at the class level
	 * 
	 */
	String entryPointName() default "";

	/**
	 * The user defined identifier for the component type. If the
	 * componentType() is null the div, and script tag for the component will
	 * not be rendered. This is used for example with BaseClasses
	 * 
	 * This parameter is applicable at the class level
	 */
	String componentType() default "";

	/**
	 * 
	 * When applied to event handler methods one can specify to use the Tapestry
	 * bubbling mechanisms, i.e. when the return type is void or the return type
	 * is a boolean value of true the event is bubbled to the container.
	 * 
	 * When working with GWT one would like to have a 'void' or a 'boolean'
	 * return type without triggering the bubbling machinery of Tapestry.
	 * 
	 * The default value for bubbling is true, thus the normal Tapestry behavior
	 * is used.
	 * 
	 * This parameter is applicable at the method level, it will be considered
	 * only for the event handler methods.
	 */
	boolean bubbling() default true;

}