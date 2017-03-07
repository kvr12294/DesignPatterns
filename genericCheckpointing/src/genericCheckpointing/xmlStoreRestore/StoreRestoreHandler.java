package genericCheckpointing.xmlStoreRestore;

import java.io.BufferedWriter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import genericCheckpointing.util.FileProcessor;

public class StoreRestoreHandler implements InvocationHandler{

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//System.out.println("in invoke");
//		BufferedWriter bw = (BufferedWriter) args[2];
		Class <? extends Object> className = args[0].getClass();
		String meth = method.getName();
		Object clsobj = null;
		//System.out.println(meth);
//		Object obj = className.newInstance();
//		Object[] params = new Object[1];
		//Object result = meth.invoke(obj, meth ,params); // TODO : invoke??
		String signature = null;
		String signature1 = null;
	
		if(meth.equals("writeObj"))
		{
			BufferedWriter bw = (BufferedWriter) args[2];
			bw.write("<DPSerialization>\n");
			bw.write("<complexType xsi:type=" + "\"" + className.getCanonicalName() + "\"" + ">\n");
			Field[] field = className.getDeclaredFields();
			//System.out.println("classname:-" + className.getCanonicalName());
			  for (int j=0; j<field.length; j++) 
			  {
	              String fieldClass = field[j].getType().getSimpleName();
	              String fieldName = field[j].getName();
	              signature = "get" + fieldName;
	              Method methodName = className.getMethod(signature);
	              Object invokeRet = methodName.invoke(args[0], null);
	              //System.out.println("Method is " + methodName);
	             // methodName.setAccessible(true);
	             // result = methodName.invoke(sObject, (Object[]) null);
	              //System.out.println(signature);
//	              Object fieldObject = 
//					 field[j].get(className);
//	              if(fieldName.equals(anObject))
//				  {
//					  
//				  }
	             // fieldClass = fieldClass.equals("class java.lang.String") ? "String".toString():fieldClass;
	              bw.write("<" + fieldName + " xsi:type=\"xsd:" + fieldClass  + "\">" + invokeRet + "</" + fieldName + ">\n");
			  }
			  bw.write("</complexType>\n");
			  bw.write("</DPSerialization>\n");
		}
		else if(meth.equals("readObj"))
		{
			//System.out.println("in read" + args.length);
			//FileProcessor fp = new FileProcessor((String) args[0]);
			FileProcessor fp = (FileProcessor) args[1];
//			Object clsobj = null;
			String clsname = null;
			Class cls = null;
			//System.out.println("in read for 2nd");
			String line = "";
			while ((line = fp.readLineFromFile()) != null) 
			{
				if((line.contains("DPSerialization")))
				{
					continue;
				}
				if(line.contains("/DPSerialization") || line.contains("</complexType>"))
				{
					return clsobj;
				}
				else if(line.contains("complexType"))
				{
					//String[] parts = line.split("=");
					//System.out.println("in complex");
					int index = line.indexOf("\"");
					//System.out.println("index" + index);
					if(index == -1)
					{
						continue;
					}
					int index1 = line.indexOf("\"", index + 1);
					if(index1 == -1)
					{
						continue;
					}
					clsname = line.substring(index + 1, index1);
					//System.out.println(clsname);
					//System.out.println("indexes:" + index + " " + index1);
				
					try {
						cls = Class.forName(clsname);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						//System.out.println("e.printStackTrace());
						//System.out.println("CLASS"+e.toString());
					}
					
				try {
					clsobj = cls.newInstance();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("hehe-"+e.toString());
				}
				//System.out.println("OBJECT");
				}
				else
				{
					//System.out.println("else");
					int index2 = line.indexOf("x");
					//System.out.println("sjakdh" + index2);
					String name = line.substring(1, index2 - 1);
//					System.out.println(name);
					String[] parts = line.split(":");
					int in = parts[2].indexOf("\"");
					String type = parts[2].substring(0, in);
//					System.out.println(type);
					String[] parts1 = parts[2].split(">");
					int in1 = parts1[1].indexOf("<");
					String value = parts1[1].substring(0, in1);
//					System.out.println(value);
					//int in2 = parts1[1].indexOf("/");
					String[] parts2 = parts1[1].split("/");
					//System.out.println(parts2[1]);
					String value1 = parts2[1];	
//					System.out.println(value1);
					Class dt = null;
					if(type.equals("int"))
					{
						dt = Integer.TYPE;
						signature1 = "set" + name;
//						System.out.println(signature1);
			            Method m = cls.getMethod(signature1, new Class[] {dt});
			            m.invoke(clsobj, Integer.parseInt(value));
					}
					else if(type.equals("long"))
					{
						dt = Long.TYPE;
						signature1 = "set" + name;
//						System.out.println(signature1);
			            Method m = cls.getMethod(signature1, new Class[] {dt});
			            m.invoke(clsobj, Long.parseLong(value));
					}
					else if(type.equals("String"))
					{
						dt = String.class;
						signature1 = "set" + name;
//						System.out.println(signature1);
			            Method m = cls.getMethod(signature1, new Class[] {dt});
			            m.invoke(clsobj, value);
					}
					else if(type.equals("boolean"))
					{
						dt = Boolean.TYPE;
						signature1 = "set" + name;
//						System.out.println(signature1+" "+value);
			            Method m = cls.getMethod(signature1, new Class[] {dt});
			            m.invoke(clsobj, Boolean.parseBoolean(value));
					}
					else if(type.equals("double"))
					{
						//System.out.println("DOUBLE");
						dt = Double.TYPE;
						signature1 = "set" + name;
						//System.out.println(signature1);
			            Method m = cls.getMethod(signature1, new Class[] {dt});
			            m.invoke(clsobj, Double.parseDouble(value));
					}
					else if(type.equals("float"))
					{
						dt = Float.TYPE;
						signature1 = "set" + name;
//						System.out.println(signature1);
			            Method m = cls.getMethod(signature1, new Class[] {dt});
			            m.invoke(clsobj, Float.parseFloat(value));
					}
					else if(type.equals("short"))
					{
						dt = Short.TYPE;
						signature1 = "set" + name;
						//System.out.println(signature1);
						Method m = cls.getMethod(signature1, new Class[] {dt});
			            m.invoke(clsobj, Short.parseShort(value));
					}
					else if(type.equals("char"))
					{
						dt = Character.TYPE;
						signature1 = "set" + name;
//						System.out.println(signature1);
						Method m = cls.getMethod(signature1, new Class[] {dt});
			            m.invoke(clsobj, value.charAt(0));
					}
					
				}
			}
			return clsobj;
		}
		else
		{
			System.out.println("Incorrect Method:\n");
		}
		return clsobj;
	}
}
