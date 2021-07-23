import { AppPage } from './app.po';
import { browser, by, element, protractor } from 'protractor';
import { FavouritePage } from './favourite.po';
import { UpcomingPage } from './upcoming.po';
import { MatchcalendarPage } from './matchcalendar.po';
import { PreviousmatchesPage } from './previousmatches.po';

fdescribe('workspace-project App', () => {
  let page: AppPage;
  let favouritePage: FavouritePage;
  let upcomingPage: UpcomingPage;
  let matchcalendarPage: MatchcalendarPage;
  let previousmatchesPage: PreviousmatchesPage;
  
  beforeEach(() => {
    page = new AppPage();
    favouritePage=new FavouritePage();
    upcomingPage=new UpcomingPage();
    matchcalendarPage=new MatchcalendarPage();
    previousmatchesPage=new PreviousmatchesPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
   browser.getTitle().then(
     response=>expect(response).toContain('CMatchesUI')
   );
  });


it('should be redirected to /login route on opening the application', () => {
    browser.driver.getCurrentUrl().then(
      response=>expect(response).toContain('login')
    );
});

it('should be redirected to /register route', () => {
  element(by.css('.register-button')).click();
  browser.driver.getCurrentUrl().then(
    response=>expect(response).toContain('register')
  );
});

it('should be able to register user', () => {
  element(by.id('firstName')).sendKeys('superr12');
  element(by.id('lastName')).sendKeys('superr12');
  element(by.id('userId')).sendKeys('superr12');
  element(by.id('password')).sendKeys('123456');
  element(by.css('.register-user')).click();
  browser.driver.getCurrentUrl().then(
    response=>expect(response).toContain('login')
  );
 
});

it('should be able to login user and navigate to upcoming matches', () => {
  element(by.id('userId')).sendKeys('superr12');
  element(by.id('password')).sendKeys('123456');
  element(by.css('.login-user')).click();
  browser.driver.sleep(1500);
  browser.driver.getCurrentUrl().then(
    response=>expect(response).toContain('matches/upcoming')
  );
  upcomingPage.getTitleText().then(
    response=>expect(response).toContain('Upcoming Matches!')
  );
});

it('should be able to navigate to favourite matches', () => {
  element(by.css('.favourite-button')).click();
  browser.driver.getCurrentUrl().then(
    response=>expect(response).toContain('matches/favourites')
  );
  favouritePage.getTitleText().getText().then(
    response=>expect(response).toContain('My Favourites!')
  );
 
});

it('should be able to navigate to previous matches', () => {
  element(by.css('.previous-button')).click();
  browser.driver.getCurrentUrl().then(
    response=>expect(response).toContain('matches/previousmatches')
  );
  previousmatchesPage.getTitleText().getText().then(
    response=>expect(response).toContain('Previous Matches')
  );
 
  
});
it('should be able to navigate to match calendar', () => {
  element(by.css('.calendar-button')).click();
  browser.driver.getCurrentUrl().then(
    response=>expect(response).toContain('matches/matchcalendar')
  );
  matchcalendarPage.getTitleText().getText().then(
    response=>expect(response).toContain('Match Calendar')
  );
 
});

it('should be able to navigate to login page after logging out', () => {
  element(by.css('.logout-button')).click();
  browser.driver.getCurrentUrl().then(
    response=>expect(response).toContain('login')
  );
 
});



});

