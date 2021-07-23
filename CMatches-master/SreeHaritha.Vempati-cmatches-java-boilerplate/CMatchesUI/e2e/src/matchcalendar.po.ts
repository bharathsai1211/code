import { browser, by, element } from 'protractor';

export class MatchcalendarPage {

    getTitleText() {
        return element(by.css('h1'));
      }


}