import { AppPage } from './app.po';
import { browser, by, element, logging } from 'protractor';

describe('workspace-project App', () => {
  let page: AppPage;

  beforeEach(() => {
    page = new AppPage();
  });

  // test for checking base url is redirected to base url or not
  it ('should load a page and verify the url', () => {
        browser.get('/');
        expect(browser.getCurrentUrl())
            .toContain(browser.baseUrl + '');
  });


  it('should contain <router-outlet>', () => {
        page.navigateTo();
        expect(page.getRouterOutlet).toBeTruthy('<router-outlet> should exist in app.component.html');
  });


  //display signup page on clicking signup button
  it('should display signup page on clicking signup button',()=>{
        browser.get('/');
        element(by.linkText('Sign Up')).click();
        expect(browser.getCurrentUrl())
        .toContain(browser.baseUrl + 'signup');
  });


  //diaplay login page on clicking login button
  it('should display login page on clicking login button',()=>{
    browser.get('/');
    element(by.linkText('Log In')).click();
    expect(browser.getCurrentUrl())
    .toContain(browser.baseUrl + 'login');
  });


  //display hotspots on clicking hotspots button
  it('should display hotspots list on clicking hotspots button',()=>{
     browser.get('/');
     element(by.linkText('HotSpots')).click();
     expect(browser.getCurrentUrl())
    .toContain(browser.baseUrl + 'hotSpots');
   });

  
  // given empty input for userId and password for signin and signup
  it('should check if userId and password is empty', async () => {
        page.navigateToLogin();
        element(by.css('input[type="email"]')).sendKeys('');
        element(by.css('input[type="text"]')).sendKeys('');
        element(by.css('.btn')).click();
        expect(element(by.linkText('Please verify entered details!!!')));
   });

  // given invalid userId and password for signin and signup
  it('should check form if userId and password is invalid', async () => {
      page.navigateToLogin();
      element(by.css('input[type="email"]')).sendKeys('test');
      element(by.css('input[type="text"]')).sendKeys('12345');
      element(by.css('.btn')).click();
      expect(element(by.linkText('Please verify entered details!!!')));
    });

  // given valid userId and password for signin and signup
    it('should check form if userId and password is valid', async () => {
        page.navigateToLogin();
        element(by.css('input[type="email"]')).sendKeys('test@gmail.com');
        element(by.css('input[type="text"]')).sendKeys('123456')
        element(by.css('.btn')).click();
        expect(element(by.linkText('Logged in successfully!!!')));
      });
    

  afterEach(async () => {
    // Assert that there are no errors emitted from the browser
    const logs = await browser.manage().logs().get(logging.Type.BROWSER);
    expect(logs).not.toContain(jasmine.objectContaining({
      level: logging.Level.SEVERE,
    } as logging.Entry));
  });
});
