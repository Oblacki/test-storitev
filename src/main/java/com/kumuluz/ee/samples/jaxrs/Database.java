/*
 *  Copyright (c) 2014-2017 Kumuluz and/or its affiliates
 *  and other contributors as indicated by the @author tags and
 *  the contributor list.
 *
 *  Licensed under the MIT License (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  https://opensource.org/licenses/MIT
 *
 *  The software is provided "AS IS", WITHOUT WARRANTY OF ANY KIND, express or
 *  implied, including but not limited to the warranties of merchantability,
 *  fitness for a particular purpose and noninfringement. in no event shall the
 *  authors or copyright holders be liable for any claim, damages or other
 *  liability, whether in an action of contract, tort or otherwise, arising from,
 *  out of or in connection with the software or the use or other dealings in the
 *  software. See the License for the specific language governing permissions and
 *  limitations under the License.
*/
package com.kumuluz.ee.samples.jaxrs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Benjamin Kastelic
 * @since 2.3.0
 */
public class Database {
    private static List<Customer> customers = new ArrayList<>();
    private static List<Apartment> apartments = new ArrayList<>();

    public static List<Customer> getCustomers() {
        return customers;
    }
    public static List<Apartment> getApartments() { return apartments; }

    //customers
    public static Customer getCustomer(String customerId) {
        for (Customer customer : customers) {
            if (customer.getId().equals(customerId))
                return customer;
        }
        return null;
    }

    public static void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public static void deleteCustomer(String customerId) {
        for (Customer customer : customers) {
            if (customer.getId().equals(customerId)) {
                customers.remove(customer);
                break;
            }
        }
    }

    //apartments
    public static void deleteApartment(String apartmentId) {
        for (Apartment apartment : apartments) {
            if (apartment.getId().equals(apartmentId)) {
                apartments.remove(apartment);
                break;
            }
        }
    }

    public static Apartment getApartment(String apartmentId) {
        for (Apartment apartment : apartments) {
            if (apartment.getId().equals(apartmentId))
                return apartment;
        }
        return null;
    }

    public static void addApartment(Apartment apartment) {
        apartments.add(apartment);
    }

    public static List<Apartment> getApartmentByCustomerId(String customerId) {
        List<Apartment> apartments = new ArrayList<Apartment>();

        for (Apartment apartment : apartments) {
            if (apartment.getCustomerId().equals(customerId))
                apartments.add(apartment);
        }
        return apartments;
    }

}
