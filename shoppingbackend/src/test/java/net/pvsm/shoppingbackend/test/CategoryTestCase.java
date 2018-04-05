package net.pvsm.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.pvsm.shoppingbackend.dao.CategoryDAO;
import net.pvsm.shoppingbackend.dto.Category;

public class CategoryTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDAO categoryDAO;
	
	private Category category;
	
	@BeforeClass
	public static void init(){
		context= new AnnotationConfigApplicationContext();
		context.scan("net.pvsm.shoppingbackend");
		context.refresh();
		categoryDAO= (CategoryDAO) context.getBean("catagoryDAO");
	}
	
	/*
	 * Test List of items
	 */
	/*@Test
	public void testListCategories(){
		
		assertEquals("Succssfully get list of category", 3,categoryDAO.list().size());	
	}
	*/
	/**
	 * Test Add category
	 */
	/*@Test
	public void testAddCategory(){
		category= new Category();
		
		category.setName("Toys");
		category.setDescription("This is description for Toys");
		category.setImageURL("CAT_101.png");
		
		assertEquals("Successfully Added in Categary table", true, categoryDAO.add(category));
	}*/

	
/*	@Test
	public void testCategory(){
		
		category = categoryDAO.get(1);
		assertEquals("successfulled fetched single category","Television",category.getName());
		
	}
*/	
	/**
	 * test update category
	 */
	/*@Test
	public void testUpdateCategory(){
		category= categoryDAO.get(1);
		category.setName("TV");
		assertEquals("successfulled update single category",true,categoryDAO.update(category));
		
	}
	*/
	
	/*@Test
	public void testDeleteCategory(){
		
		category= categoryDAO.get(3);
		assertEquals("successfulled delete single category",true,categoryDAO.delete(category));
		
		
	}
	*/
	
	
	@Test
	public void testCRUDcategory(){
		
		
		//Add operation
		category= new Category();
		
		category.setName("Television");
		category.setDescription("This is description for Television");
		category.setImageURL("CAT_101.png");
		
		assertEquals("Successfully Added in Categary table", true, categoryDAO.add(category));
		

		category= new Category();
		
		category.setName("Mobile");
		category.setDescription("This is description for Television");
		category.setImageURL("CAT_102.png");
		
		assertEquals("Successfully Added in Categary table", true, categoryDAO.add(category));
		
		//update operation
		
		category= categoryDAO.get(1);
		category.setName("Television");
		assertEquals("successfulled update single category",true,categoryDAO.update(category));
		
		//delete operation
		
		category= categoryDAO.get(1);
		assertEquals("successfulled delete single category",true,categoryDAO.delete(category));
		
		//list
		
		assertEquals("Succssfully get list of category", 9,categoryDAO.list().size());
		
		
		
	}
	
	
	
}
