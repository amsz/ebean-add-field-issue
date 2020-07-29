# Add field demo

Read old model data will throw ArrayIndexOutOfBoundsException after add a new field 

## reproduce

#### step1

run TestMain


#### step2

1. TestModel - uncomment field1 code
2. TestMain - comment `run1()` and uncomment `run2()`
3. run TestMain again 

```java
Caused by: java.lang.ArrayIndexOutOfBoundsException: 1
at io.ebean.bean.EntityBeanIntercept.isLoadedProperty(EntityBeanIntercept.java:538)
at io.ebean.bean.EntityBeanIntercept.preGetter(EntityBeanIntercept.java:912)
at demo.TestModel._ebean_get_field1(TestModel.java:6)
at demo.TestModel.getField1(TestModel.java:29)
```
