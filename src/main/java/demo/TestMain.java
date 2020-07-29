package demo;

import io.ebean.DB;

import java.io.*;
import java.lang.reflect.Method;

/**
 *
 */
public class TestMain {
  static final String TMP_FILE = "/tmp/ebean_model.log";

  public static void main(String[] args) throws Exception {
    run1();
//    run2();
  }

  static void run1() throws Exception {
    DB.sqlUpdate("CREATE TABLE `test_model` (\n" +
      "  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,\n" +
      "  `field1` varchar(100) DEFAULT NULL,\n" +
      "  PRIMARY KEY (`id`)\n" +
      ");").execute();

    TestModel model = new TestModel();
    model.save();
    write(model);

    TestModel cacheModel = read();
    System.out.println("db:" + model.getId() + ", cache:" + cacheModel.getId());
  }

  static void run2() throws Exception {
    TestModel cached = read();
    Method field = TestModel.class.getDeclaredMethod("getField1");
    System.out.println("new field: " + field.invoke(cached));
  }

  static void write(TestModel model) throws IOException {
    try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(TMP_FILE))) {
      out.writeObject(model);
      out.flush();
    }
  }

  static TestModel read() throws Exception {
    try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(TMP_FILE))) {
      return (TestModel) in.readObject();
    }
  }
}
