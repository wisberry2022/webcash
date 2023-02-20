package com.bit.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DeptDaoTest {
   // 독립적인 개체로 테스팅하므로 같은Dao가 아님 그렇기 때문에 static으로 해줘야함
   static DeptDao dao; 
   static DeptDto target;
   
   @BeforeClass
   public static void beforeClass() {
      System.out.println("beforeClass");
      target = new DeptDto();
      target.setDeptno(9999);
      target.setDname("test1");
      target.setLoc("test2");
   }
   
   @Before
   public void before() {
      System.out.println("before");
      dao = new DeptDao();
   }
   
   @Test
   public void test1SelectAll() {
      
      assertNotNull(dao.selectAll());
      assertTrue(dao.selectAll().size()>0);
   }

   @Test
   public void test3SelectOne() {
      assertEquals(target,dao.selectOne(target.getDeptno()));
   }

   @Test
   public void test2InsertOne() {
      assertSame(0,dao.insertOne(target.getDeptno(),target.getDname(),target.getLoc()));
   }

   @Test
   public void test4UpdateOne() {
      target.setDname("test2");
      target.setLoc("test1");
      assertSame(0,dao.updateOne(target.getDeptno(),target.getDname(),target.getLoc()));
   }

   @Test
   public void test5DeleteOne() {
      assertSame(0,dao.deleteOne(target.getDeptno()));
   }

}