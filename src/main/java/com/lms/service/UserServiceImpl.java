package com.lms.service;

import com.lms.entity.Loan;
import com.lms.entity.User;
import com.lms.exception.UserNotFoundException;
import com.lms.exception.UserRequiredFieldException;
import com.lms.repository.LoanRepository;
import com.lms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LoanRepository loanRepository;

    @Override
    @Transactional
    public User saveUser(User user) {

        if(user.getEmail() == null){
            throw new UserRequiredFieldException("Email cannot be null");
        }

        if(user.getPhone() == null){
            throw new UserRequiredFieldException("Phone number cannot be null");
        }

        Loan loan = new Loan();

        loan.setId(user.getLoan().getId());
        loan.setName(user.getLoan().getName());
        loan.setAmount(user.getLoan().getAmount());

        loanRepository.save(loan);

        User tempUser = new User();

        tempUser.setLoan(loan);
        tempUser.setName(user.getName());
        tempUser.setPhone(user.getPhone());
        tempUser.setEmail(user.getEmail());


        return userRepository.save(tempUser);
    }

    @Override
    public User getUser(int id) {
        return userRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundException("User Not Found Id: "+id));
    }

    @Override
    public List<User> listOfUser() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {

        User tempUser = userRepository.findById(user.getId())
                .orElseThrow(()-> new UserNotFoundException("User Not Found Id: "+user.getId()));

        if(user.getName() == null){
            user.setName(tempUser.getName());
        }

        if(user.getEmail() == null){
            user.setEmail(tempUser.getEmail());
        }

        if(user.getPhone() == null){
            user.setPhone(tempUser.getPhone());
        }

        if(user.getLoan() == null){
            user.setLoan(tempUser.getLoan());
        }

        return userRepository.save(user);
    }

    @Override
    public void deleteUserById(int id) {
        userRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundException("User Not Found Id: "+id));
        userRepository.deleteById(id);
    }
}
