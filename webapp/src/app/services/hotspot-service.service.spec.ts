import { TestBed } from '@angular/core/testing';

import { HotspotServiceService } from './hotspot-service.service';

describe('HotspotServiceService', () => {
  let service: HotspotServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HotspotServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
