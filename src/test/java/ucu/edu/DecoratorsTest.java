package ucu.edu;
import ucu.edu.model.Item;
import ucu.edu.model.decorators.PaperDecorator;
import ucu.edu.model.decorators.RibbonDecorator;
import ucu.edu.model.decorators.BasketDecorator;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DecoratorTest {

    private Item basicItem;

    @BeforeEach

    void setUp() {
        basicItem = new Item() {
            @Override
            public double getPrice() {
                return 100.0;
            }

            @Override
            public String getDescription() {
                return "Basic Item";
            }
        };
    }

    @Test
    void testPaperDecoratorConstructor() {
        PaperDecorator paperDecorator = new PaperDecorator(basicItem);
        assertNotNull(paperDecorator, "PaperDecorator should be instantiated");
    }

    @Test
    void testPaperDecoratorPrice() {
        Item decoratedItem = new PaperDecorator(basicItem);
        assertEquals(113.0, decoratedItem.getPrice(), "Price should be base price plus 13");
    }

    @Test
    void testPaperDecoratorDescription() {
        Item decoratedItem = new PaperDecorator(basicItem);
        assertEquals("Basic Item, in a paper", decoratedItem.getDescription(), "Description should include paper decoration");
    }

    @Test
    void testBasketDecoratorConstructor() {
        BasketDecorator basketDecorator = new BasketDecorator(basicItem);
        assertNotNull(basketDecorator, "BasketDecorator should be instantiated");
    }

    @Test
    void testBasketDecoratorPrice() {
        Item decoratedItem = new BasketDecorator(basicItem);
        assertEquals(104.0, decoratedItem.getPrice(), "Price should be base price plus 4");
    }

    @Test
    void testBasketDecoratorDescription() {
        Item decoratedItem = new BasketDecorator(basicItem);
        assertEquals("Basic Item, in a basket", decoratedItem.getDescription(), "Description should include basket decoration");
    }

    @Test
    void testRibbonDecoratorConstructor() {
        RibbonDecorator ribbonDecorator = new RibbonDecorator(basicItem);
        assertNotNull(ribbonDecorator, "RibbonDecorator should be instantiated");
    }

    @Test
    void testRibbonDecoratorPrice() {
        Item decoratedItem = new RibbonDecorator(basicItem);
        assertEquals(140.0, decoratedItem.getPrice(), "Price should be base price plus 40");
    }

    @Test
    void testRibbonDecoratorDescription() {
        Item decoratedItem = new RibbonDecorator(basicItem);
        assertEquals("Basic Item, in a ribbon", decoratedItem.getDescription(), "Description should include ribbon decoration");
    }

    @Test
    void testMultipleDecoratorsPrice() {
        Item decoratedItem = new RibbonDecorator(new BasketDecorator(new PaperDecorator(basicItem)));
        assertEquals(157.0, decoratedItem.getPrice(), "Price should include all decorations: 100 + 13 + 4 + 40");
    }

    @Test
    void testMultipleDecoratorsDescription() {
        Item decoratedItem = new RibbonDecorator(new BasketDecorator(new PaperDecorator(basicItem)));
        assertEquals("Basic Item, in a paper, in a basket, in a ribbon", decoratedItem.getDescription(), "Description should include all decorations");
    }

    @Test
    void testNestedDecoratorsPrice() {
        Item decoratedItem = new PaperDecorator(new PaperDecorator(basicItem));
        assertEquals(126.0, decoratedItem.getPrice(), "Price should reflect two layers of PaperDecorator");
    }

    @Test
    void testNestedDecoratorsDescription() {
        Item decoratedItem = new PaperDecorator(new PaperDecorator(basicItem));
        assertEquals("Basic Item, in a paper, in a paper", decoratedItem.getDescription(), "Description should reflect two layers of PaperDecorator");
    }

    @Test
    void testDecoratorWithNoDecorations() {
        assertEquals(100.0, basicItem.getPrice(), "Basic item price should be 100.0");
        assertEquals("Basic Item", basicItem.getDescription(), "Basic item description should be 'Basic Item'");
    }
}
