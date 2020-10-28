package io.swisschain.policy.base;

import java.math.BigDecimal;

public class TransferDetails {
  private long operationId;
  private Blockchain blockchain;
  private Asset asset;
  private SourceAddress sourceAddress;
  private DestinationAddress destinationAddress;
  private BigDecimal amount;
  private BigDecimal feeLimit;
  
  public TransferDetails() {
}

public TransferDetails(long operationId, Blockchain blockchain, Asset asset, SourceAddress sourceAddress,
		DestinationAddress destinationAddress, BigDecimal amount, BigDecimal feeLimit) {
	super();
	this.operationId = operationId;
	this.blockchain = blockchain;
	this.asset = asset;
	this.sourceAddress = sourceAddress;
	this.destinationAddress = destinationAddress;
	this.amount = amount;
	this.feeLimit = feeLimit;
  }
  
  /** Gets the operation identifier in Sirius. */
  public long getOperationId() {
    return operationId;
  }

  /** Sets the operation identifier in Sirius. */
  public void setOperationId(long operationId) {
    this.operationId = operationId;
  }

  /** Gets the blockchain details. */
  public Blockchain getBlockchain() {
    return blockchain;
  }

  /** Sets the blockchain details. */
  public void setBlockchain(Blockchain blockchain) {
    this.blockchain = blockchain;
  }

  /** Gets the blockchain asset details. */
  public Asset getAsset() {
    return asset;
  }

  /** Sets the blockchain asset details. */
  public void setAsset(Asset asset) {
    this.asset = asset;
  }

  /** Gets the transfer source address details. */
  public SourceAddress getSourceAddress() {
    return sourceAddress;
  }

  /** Sets the transfer source address details. */
  public void setSourceAddress(SourceAddress sourceAddress) {
    this.sourceAddress = sourceAddress;
  }

  /** Gets the transfer destination address details. */
  public DestinationAddress getDestinationAddress() {
    return destinationAddress;
  }

  /** Sets the transfer destination address details. */
  public void setDestinationAddress(DestinationAddress destinationAddress) {
    this.destinationAddress = destinationAddress;
  }

  /** Gets the transfer amount. */
  public BigDecimal getAmount() {
    return amount;
  }

  /** Sets the transfer amount. */
  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  /** Gets the maximum allowed fee for this transfer. */
  public BigDecimal getFeeLimit() {
    return feeLimit;
  }

  /** Sets the maximum allowed fee for this transfer. */
  public void setFeeLimit(BigDecimal feeLimit) {
    this.feeLimit = feeLimit;
  }  
}
