package genericCheckpointing.server;

import java.io.BufferedWriter;

import genericCheckpointing.util.MyAllTypesFirst;
import genericCheckpointing.util.MyAllTypesSecond;

public interface StoreI extends StoreRestoreI{
	public void writeObj(MyAllTypesFirst myFirst, String wireFormat, BufferedWriter bw );
	public void writeObj(MyAllTypesSecond mySecond, String wireFormat, BufferedWriter bw);
}
