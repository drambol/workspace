package baseline;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.ButtonReleaseAction;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.interactions.ClickAndHoldAction;
import org.openqa.selenium.interactions.ContextClickAction;
import org.openqa.selenium.interactions.DoubleClickAction;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.KeyDownAction;
import org.openqa.selenium.interactions.KeyUpAction;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.interactions.MoveMouseAction;
import org.openqa.selenium.interactions.MoveToOffsetAction;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.internal.Locatable;

public class MyActions {

    protected Mouse mouse;
    protected Keyboard keyboard;
    protected MyCompositeAction action;
	
	public MyActions(WebDriver driver) {
        this(((HasInputDevices)driver).getKeyboard(), ((HasInputDevices)driver).getMouse());
    }
	
	public MyActions(Keyboard keyboard, Mouse mouse) {
        this.mouse = mouse;
        this.keyboard = keyboard;
        resetCompositeAction();
    }

    public MyActions(Keyboard keyboard) {
        this.keyboard = keyboard;
        resetCompositeAction();
    }

    private void resetCompositeAction() {
        action = new MyCompositeAction();
    }

    public MyActions keyDown(Keys theKey) {
        return keyDown(null, theKey);
    }

    public MyActions keyDown(WebElement element, Keys theKey) {
        action.addAction(new KeyDownAction(keyboard, mouse, (Locatable)element, theKey));
        return this;
    }

    public MyActions keyUp(Keys theKey) {
        return keyUp(null, theKey);
    }

    public MyActions keyUp(WebElement element, Keys theKey) {
        action.addAction(new KeyUpAction(keyboard, mouse, (Locatable)element, theKey));
        return this;
    }

    public MyActions sendKeys(CharSequence keysToSend[]) {
        return sendKeys(null, keysToSend);
    }

    public MyActions sendKeys(WebElement element, CharSequence keysToSend[]) {
        action.addAction(new SendKeysAction(keyboard, mouse, (Locatable)element, keysToSend));
        return this;
    }

    public MyActions clickAndHold(WebElement onElement) {
        action.addAction(new ClickAndHoldAction(mouse, (Locatable)onElement));
        return this;
    }

    public MyActions clickAndHold() {
        return clickAndHold(null);
    }

    public MyActions release(WebElement onElement) {
        action.addAction(new ButtonReleaseAction(mouse, (Locatable)onElement));
        return this;
    }

    public MyActions release() {
        return release(null);
    }

    public MyActions click(WebElement onElement) {
        action.addAction(new ClickAction(mouse, (Locatable)onElement));
        return this;
    }

    public MyActions click() {
        return click(null);
    }

    public MyActions doubleClick(WebElement onElement) {
        action.addAction(new DoubleClickAction(mouse, (Locatable)onElement));
        return this;
    }

    public MyActions doubleClick() {
        return doubleClick(null);
    }

    public MyActions moveToElement(WebElement toElement) {
        action.addAction(new MoveMouseAction(mouse, (Locatable)toElement));
        return this;
    }

    public MyActions moveToElement(WebElement toElement, int xOffset, int yOffset) {
        action.addAction(new MoveToOffsetAction(mouse, (Locatable)toElement, xOffset, yOffset));
        return this;
    }

    public MyActions moveByOffset(int xOffset, int yOffset) {
        action.addAction(new MoveToOffsetAction(mouse, null, xOffset, yOffset));
        return this;
    }

    public MyActions contextClick(WebElement onElement) {
        action.addAction(new ContextClickAction(mouse, (Locatable)onElement));
        return this;
    }

    public MyActions contextClick() {
        return contextClick(null);
    }

    public MyActions dragAndDrop(WebElement source, WebElement target) {
        action.addAction(new ClickAndHoldAction(mouse, (Locatable)source));
        action.addAction(new MoveMouseAction(mouse, (Locatable)target));
        action.addAction(new ButtonReleaseAction(mouse, (Locatable)target));
        return this;
    }

    public MyActions dragAndDropBy(WebElement source, int xOffset, int yOffset) {
        action.addAction(new ClickAndHoldAction(mouse, (Locatable)source));
        action.addAction(new MoveToOffsetAction(mouse, null, xOffset, yOffset));
        action.addAction(new ButtonReleaseAction(mouse, null));
        return this;
    }

    public Action build() {
        MyCompositeAction toReturn = action;
        resetCompositeAction();
        return toReturn;
    }

    public void perform() {
        build().perform();
    }

}
