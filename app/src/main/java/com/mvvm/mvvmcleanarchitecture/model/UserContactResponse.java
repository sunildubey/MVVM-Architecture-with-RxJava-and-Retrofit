package com.mvvm.mvvmcleanarchitecture.model;

import java.util.List;

public class UserContactResponse {

    /**
     * status : success
     * payload : {"patientList":[{"vitalsCount":0,"orgNodeName":"Staff Clinic at HBS","medicationCount":0,"address":"16625 Dove Canyon RoadSuite 104, San Diego, CA 92127","diagnosis":[{"diagnosisID":132,"userDiagnosisID":3,"diagnosisCode":"291","diagnosisName":"Heart failure and shock","diagnosisImageName":"views/base/assets/images/diagnosis/heartfailure.png","active":"YES","createdByUserName":"ADMINISTRATOR","createdDate":1516393560000,"modifiedByUserName":"ADMINISTRATOR","modifiedDate":1516393560000,"diagnosisDeviceMappingList":null},{"diagnosisID":273,"userDiagnosisID":1,"diagnosisCode":"637","diagnosisName":"Diabetes with mcc","diagnosisImageName":"views/base/assets/images/diagnosis/diabetes.png","active":"YES","createdByUserName":"ADMINISTRATOR","createdDate":1516393560000,"modifiedByUserName":"ADMINISTRATOR","modifiedDate":1516393560000,"diagnosisDeviceMappingList":null},{"diagnosisID":100,"userDiagnosisID":2,"diagnosisCode":"190","diagnosisName":"Chronic obstructive pulmonary disease","diagnosisImageName":"views/base/assets/images/diagnosis/copd.png","active":"YES","createdByUserName":"ADMINISTRATOR","createdDate":1516393560000,"modifiedByUserName":"ADMINISTRATOR","modifiedDate":1516393560000,"diagnosisDeviceMappingList":null}],"healthScore":0,"userID":8,"firstName":"Michael","lastName":"Beven","age":29,"dob":643420800000,"gender":"MALE","userTypeID":4,"MRN":"CR1040105","mobileNumber":"9174435814","homeNumber":"","officeNumber":""}]}
     * exception : {}
     */

    private String status;
    private PayloadBean payload;
    private ExceptionBean exception;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public PayloadBean getPayload() {
        return payload;
    }

    public void setPayload(PayloadBean payload) {
        this.payload = payload;
    }

    public ExceptionBean getException() {
        return exception;
    }

    public void setException(ExceptionBean exception) {
        this.exception = exception;
    }

    public static class PayloadBean {
        private List<PatientListBean> patientList;

        public List<PatientListBean> getPatientList() {
            return patientList;
        }

        public void setPatientList(List<PatientListBean> patientList) {
            this.patientList = patientList;
        }

        public static class PatientListBean {
            /**
             * vitalsCount : 0
             * orgNodeName : Staff Clinic at HBS
             * medicationCount : 0
             * address : 16625 Dove Canyon RoadSuite 104, San Diego, CA 92127
             * diagnosis : [{"diagnosisID":132,"userDiagnosisID":3,"diagnosisCode":"291","diagnosisName":"Heart failure and shock","diagnosisImageName":"views/base/assets/images/diagnosis/heartfailure.png","active":"YES","createdByUserName":"ADMINISTRATOR","createdDate":1516393560000,"modifiedByUserName":"ADMINISTRATOR","modifiedDate":1516393560000,"diagnosisDeviceMappingList":null},{"diagnosisID":273,"userDiagnosisID":1,"diagnosisCode":"637","diagnosisName":"Diabetes with mcc","diagnosisImageName":"views/base/assets/images/diagnosis/diabetes.png","active":"YES","createdByUserName":"ADMINISTRATOR","createdDate":1516393560000,"modifiedByUserName":"ADMINISTRATOR","modifiedDate":1516393560000,"diagnosisDeviceMappingList":null},{"diagnosisID":100,"userDiagnosisID":2,"diagnosisCode":"190","diagnosisName":"Chronic obstructive pulmonary disease","diagnosisImageName":"views/base/assets/images/diagnosis/copd.png","active":"YES","createdByUserName":"ADMINISTRATOR","createdDate":1516393560000,"modifiedByUserName":"ADMINISTRATOR","modifiedDate":1516393560000,"diagnosisDeviceMappingList":null}]
             * healthScore : 0
             * userID : 8
             * firstName : Michael
             * lastName : Beven
             * age : 29
             * dob : 643420800000
             * gender : MALE
             * userTypeID : 4
             * MRN : CR1040105
             * mobileNumber : 9174435814
             * homeNumber :
             * officeNumber :
             */

            private int vitalsCount;
            private String orgNodeName;
            private int medicationCount;
            private String address;
            private Double healthScore;
            private int userID;
            private String firstName;

            public int getVitalsCount() {
                return vitalsCount;
            }

            public void setVitalsCount(int vitalsCount) {
                this.vitalsCount = vitalsCount;
            }

            public String getOrgNodeName() {
                return orgNodeName;
            }

            public void setOrgNodeName(String orgNodeName) {
                this.orgNodeName = orgNodeName;
            }

            public int getMedicationCount() {
                return medicationCount;
            }

            public void setMedicationCount(int medicationCount) {
                this.medicationCount = medicationCount;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public Double getHealthScore() {
                return healthScore;
            }

            public void setHealthScore(Double healthScore) {
                this.healthScore = healthScore;
            }

            public int getUserID() {
                return userID;
            }

            public void setUserID(int userID) {
                this.userID = userID;
            }

            public String getFirstName() {
                return firstName;
            }

            public void setFirstName(String firstName) {
                this.firstName = firstName;
            }

            public static class DiagnosisBean {
            }
        }
    }

    public static class ExceptionBean {
    }
}
