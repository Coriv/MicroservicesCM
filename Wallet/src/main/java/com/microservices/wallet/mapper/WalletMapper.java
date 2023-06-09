package com.microservices.wallet.mapper;

import com.microservices.wallet.entity.Wallet;
import com.microservices.wallet.dto.WalletDto;
import com.microservices.wallet.repository.WalletDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WalletMapper {

    private final WalletDao walletDao;

    public Wallet mapToWallet(WalletDto walletDto) {
        Wallet wallet;
        wallet = walletDao.findById(walletDto.getId()).orElse(new Wallet());
        wallet.setCurrency(wallet.getCurrency());
        wallet.setQuantity(walletDto.getQuantity());
        wallet.setUserId(walletDto.getUserId());
        return wallet;
    }

    public WalletDto mapToWalletDto(Wallet wallet) {
        return WalletDto.builder()
                .id(wallet.getId())
                .currency(wallet.getCurrency())
                .quantity(wallet.getQuantity())
                .userId(wallet.getUserId())
                .build();
    }
}
