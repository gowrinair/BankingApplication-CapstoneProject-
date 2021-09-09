import { TestBed } from '@angular/core/testing';

import { AddCustomerService } from './add-customer.service';

describe('AddCustomerService', () => {
  let service: AddCustomerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AddCustomerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
