package com.trsvax.tapestry.gwt.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.google.gwt.core.client.EntryPoint;

@Target( { TYPE, METHOD, FIELD })
@Retention(RUNTIME)
@Documented
public @interface GWT {

	/*
	 * The Class implementing the GWT EntryPoint
	 */
	Class<? extends EntryPoint> entryPoint() default EntryPoint.class;

	/*
	 * Override for the entry point to identify the entryPoint
	 */
	String entryPointName() default "";

	/*
	 * The user defined identifier for the component type. If null nothing will be rendered.
	 */
	String componentType() default "";
	
	
	
	/**
	 * When applied to event handler methods one can specify to use the Tapestry
	 * bubbling mechanisms, i.e. when the return type is void or the return type
	 * is a boolean value of true the event is bubbled to the container.
	 * 
	 * When working with GWT one would like to have a void or a plain boolean
	 * return type without triggering the bubbling machinery of Tapestry.
	 * 
	 * The default value for bubbling is true, thus the normal Tapestry behavior
	 * is used.
	 */
	boolean bubbling() default true;

}