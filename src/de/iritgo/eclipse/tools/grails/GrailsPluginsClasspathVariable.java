package de.iritgo.eclipse.tools.grails;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.ClasspathVariableInitializer;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;

public class GrailsPluginsClasspathVariable extends ClasspathVariableInitializer
{
	@Override
	public void initialize (String variable)
	{
		try
		{
			JavaCore.setClasspathVariable (variable, new Path ("~/.grails/"), new NullProgressMonitor ()); 
		}
		catch (JavaModelException x)
		{
		}
	}
}
