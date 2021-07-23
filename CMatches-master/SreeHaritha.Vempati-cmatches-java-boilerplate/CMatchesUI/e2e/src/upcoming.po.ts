import { browser, by, element } from 'protractor';

export class UpcomingPage {

    getTitleText() {
        return element(by.css('h1')).getText();
      }


}