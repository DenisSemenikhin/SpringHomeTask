package com.epam.spring.hometask.spring.aspect;

/*
@Aspect
@Component
public class DicsountAspect {


    @Autowired
    DiscountAspectDaoService discountAspectDaoService;

    public void setDiscountAspectDaoService(DiscountAspectDaoService discountAspectDaoService) {
        this.discountAspectDaoService = discountAspectDaoService;
    }

    @Pointcut("execution(* com.epam.spring.hometask.service.impl.DiscountServiceImpl.getDiscount(..))")
    private void getDiscountCall() {
    }

    @AfterReturning(pointcut = "getDiscountCall()", returning = "discount")
    public void saveDiscountCall(JoinPoint jp, Object discount) {
        Discount rDiscount = (Discount) discount;
        if (rDiscount.getDiscountValue() != 0) {
            discountAspectDaoService.saveDiscountGives(rDiscount);
        }
    }

    @AfterReturning(pointcut = "getDiscountCall()", returning = "discount")
    public void saveDiscountCallByUser(JoinPoint jp, Object discount) {
        Discount rDiscount = (Discount) discount;
        List<?> args = Arrays.asList(jp.getArgs());
        User user = (User) args.stream().filter(obj -> obj instanceof User).findAny().get();
            discountAspectDaoService.saveDiscountByUserGives(user, rDiscount);
        }
    }


*/
