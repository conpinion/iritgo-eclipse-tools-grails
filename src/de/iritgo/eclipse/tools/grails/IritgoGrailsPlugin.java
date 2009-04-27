/*
    This file is part of the Iritgo Eclipse Tools project

    (C) 2008 Iritgo Technologies
 */

package de.iritgo.eclipse.tools.grails;


import org.eclipse.ui.IStartup;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class IritgoGrailsPlugin extends AbstractUIPlugin implements IStartup
{
	/** The plug-in ID */
	public static final String PLUGIN_ID = "de.iritgo.eclipse.tools.grails";

	/** The shared instance */
	private static IritgoGrailsPlugin plugin;

	/**
	 * The constructor
	 */
	public IritgoGrailsPlugin ()
	{
	}

	/**
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start (BundleContext context) throws Exception
	{
		super.start (context);
		plugin = this;
	}

	/**
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop (BundleContext context) throws Exception
	{
		plugin = null;
		super.stop (context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static IritgoGrailsPlugin getDefault ()
	{
		return plugin;
	}

	/**
	 * @see org.eclipse.ui.IStartup#earlyStartup()
	 */
	public void earlyStartup ()
	{
	}
}
