import { browser, by, element, ElementFinder  } from 'protractor';

export class AppPage {

  navigateTo() {
    return browser.get(browser.baseUrl) as Promise<any>;
  }

  hgetTitleText() {
      return element(by.css('app-root .content span')).getText() as Promise<string>;
  }

  navigateToLogin(){
        return browser.get('/login');
      }
  navigateToSignUp(){
    return browser.get('/signup');
  }

  navigateToHotSpots(){
      return browser.get('/hotSpots');
  }
  getRouterOutlet(): ElementFinder {
      return element(by.tagName('router-outlet'));
  }
}
