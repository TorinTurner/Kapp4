import java.io.*;

public final class HexViewerandEditor {
public final static void printFile(String filePath) {
File f;
try {
f = new File(filePath);
} catch (Exception e) {
return;
}

try {

FileInputStream fis = new FileInputStream(f);
while (fis.available() > 0) {
char[] line = new char[16];
for (int i=0; i < 16; i++) {
int readByte = fis.read();
String paddingZero = (readByte < 16) ? "0" : "";
System.out.print(paddingZero + Integer.toHexString(readByte) + " ");
line[i] = (readByte >= 33 && readByte <= 126) ? (char) readByte : ‘.’;
}
System.out.println(new String(line));
}
} catch (Exception e1) { e1.printStackTrace(); }
}

public final static void main(String[] args) {
if (args.length == 0)
return;

printFile(args[0]);
}
}
