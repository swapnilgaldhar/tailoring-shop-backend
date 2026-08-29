package com.shop.tailors.service.impl;

import com.shop.tailors.dto.BillItemRequestDTO;
import com.shop.tailors.dto.BillRequestDTO;
import com.shop.tailors.entity.Bill;
import com.shop.tailors.entity.BillItem;
import com.shop.tailors.entity.Customer;
import com.shop.tailors.repository.BillItemRepository;
import com.shop.tailors.repository.BillRepository;

import com.shop.tailors.repository.CustomerRepository;
import com.shop.tailors.service.BillingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class BillingServiceImpl implements BillingService {


    private final BillRepository billRepository;

    private final CustomerRepository customerRepository;

    private final BillItemRepository billItemRepository;

    @Override
    public BillRequestDTO createBill(BillRequestDTO billRequestDTO) {

        Customer customer = customerRepository.findById(billRequestDTO.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        Bill bill = new Bill();
        bill.setCustomer(customer);
        bill.setBillDate(billRequestDTO.getBillDate());
        bill.setDeliveryDate(billRequestDTO.getDeliveryDate());
        bill.setPaidAmount(billRequestDTO.getPaidAmount());
        bill.setPaymentMode(billRequestDTO.getPaymentMode());
        bill.setNotes(billRequestDTO.getNotes());
        bill.setDiscountPer(billRequestDTO.getDiscountPer());
        bill.setDiscountAmount(billRequestDTO.getDiscountAmount());
        bill.setStatus("Pending");

        //total amount -- we will set below
        //balence amount

        double totalAmount = 0;

        for (BillItemRequestDTO dto : billRequestDTO.getBillItems()) {

            BillItem item = new BillItem();

            item.setItemName(dto.getItemName());
            item.setQuantity(dto.getQuantity());
            item.setRate(dto.getRate());

            Double amount = dto.getQuantity()*dto.getRate();

            item.setAmount(amount );

            totalAmount += amount;

            item.setBill(bill);
            bill.getBillItems().add(item);

        }
        bill.setTotalAmount(totalAmount - billRequestDTO.getDiscountAmount());//900
        bill.setBalanceAmount(totalAmount - (billRequestDTO.getPaidAmount() + billRequestDTO.getDiscountAmount()));//
        customer.setBalance((customer.getBalance() + bill.getBalanceAmount()) );//- billRequestDTO.getDiscountAmount()
        customerRepository.save(customer);
        billRepository.save(bill);
        billRequestDTO.setBillNumber(bill.getBillNumber());


        return billRequestDTO;
    }

    @Override
    public BillRequestDTO getBillDetails(String billNumber) {

        Bill bill = billRepository.findById(Long.parseLong(billNumber))
                .orElseThrow(() -> new RuntimeException("Bill not found with id: " + billNumber));

        BillRequestDTO billRequestDTO = new BillRequestDTO();
        billRequestDTO.setBillNumber(bill.getBillNumber());
        billRequestDTO.setBillDate(bill.getBillDate());
        billRequestDTO.setDeliveryDate(bill.getDeliveryDate());
        billRequestDTO.setNotes(bill.getNotes());
        billRequestDTO.setDiscountAmount(bill.getDiscountAmount());
        billRequestDTO.setDiscountPer(bill.getDiscountPer());
        billRequestDTO.setTotalAmount(bill.getTotalAmount());
        billRequestDTO.setPaymentMode(bill.getPaymentMode());
        billRequestDTO.setPaidAmount(bill.getPaidAmount());
        billRequestDTO.setBalanceAmount(bill.getBalanceAmount());
        billRequestDTO.setCustomerId(bill.getCustomer().getCustomerId());

        for (BillItem item : bill.getBillItems()) {
            BillItemRequestDTO itemDTO = new BillItemRequestDTO();
            itemDTO.setItemName(item.getItemName());
            itemDTO.setQuantity(item.getQuantity());
            itemDTO.setRate(item.getRate());
            itemDTO.setAmount(item.getAmount());
            billRequestDTO.getBillItems().add(itemDTO);
        }

        return billRequestDTO;
    }

    @Override
    public void updateDeliveryStatus(String billNumber, String status) {
        Bill bill = billRepository.findById(Long.parseLong(billNumber))
                .orElseThrow(() -> new RuntimeException("Bill not found with id: " + billNumber));
        bill.setStatus(status);
        billRepository.save(bill);
    }


}
