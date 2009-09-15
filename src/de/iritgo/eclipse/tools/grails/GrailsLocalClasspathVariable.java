package de.iritgo.eclipse.tools.grails;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.ClasspathVariableInitializer;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;

public class GrailsLocalClasspathVariable extends ClasspathVariableInitializer
{
	public static final String VARIABLE_NAME = "GRAILS_USER_HOME";

	public GrailsLocalClasspathVariable ()
	{
	}

	@Override
	public void initialize (String variable)
	{
		if (!VARIABLE_NAME.equals (variable))
		{
			return;
		}

		IPath value = JavaCore.getClasspathVariable (VARIABLE_NAME);

		if (value == null)
		{
			try
			{
				String grailsHomeDir = System.getProperty ("user.home") + File.separator + ".grails";
				String grailsVersion = ".";
				Process process = Runtime.getRuntime ().exec ("grails");
				BufferedReader in = new BufferedReader (new InputStreamReader (process.getInputStream ()));
				String line = in.readLine ();
				if (line != null)
				{
					Matcher matcher = Pattern.compile (".*Grails (\\d+\\.\\d+).*").matcher (line);
					if (matcher.matches ())
					{
						grailsVersion = matcher.group (1);
					}
				}
				process.destroy ();
				value = new Path (grailsHomeDir + File.separator + grailsVersion);
			}
			catch (Exception x)
			{
				x.printStackTrace ();
			}
		}

		if (value == null)
		{
			value = new Path ("");
		}

		try
		{
			JavaCore.setClasspathVariable (variable, value, null);
		}
		catch (JavaModelException x)
		{
			x.printStackTrace ();
		}
	}
}
