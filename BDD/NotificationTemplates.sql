INSERT INTO `BOOKING_RESTAURANT`.`NOTIFICATION` (`ID`, `TEMPLATE`, `TEMPLATE_TYPE`) VALUES 
(1, '<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <title>Booking</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>
<body style="margin: 0; padding: 0;">
  <table align="center" border="0" cellpadding="0" cellspacing="0" width="400" style="border-collapse: collapse;font-family: Arial, sans-serif; font-size: 16px; color: #9b9b9b; max-width: 600px;">
    <tr>
      <td colspan="3" width="100%" style="text-align: left;padding: 0 0 30px 0; width: 100%;">
          <img src="https://www.publicdomainpictures.net/pictures/270000/velka/restaurant-reservation-food-cus.jpg" height="230" width="100%" alt="">
      </td>
    </tr>
    <tr>
      <td colspan="3" width="100%" style="width: 100%;">
        <p style="margin: 0 0 20px 0;">Hola {name}</p>
        <p style="margin: 0 0 20px 0;"><b>Has realizado tu pago con éxito.</b> En caso de que no puedas acudir debes cancelar la reserva lo antes posible</p>
        <p style="margin: 0 0 30px 0;"></p>
      </td>
    </tr>
    <tr>
      <td width="180"></td>
      <td bgcolor="#c90c0c" width="240px" style="text-align: center;
          width: 240px;
          display: block;
          border: 1px solid transparent;
          border-radius: 2px;
          font-weight: 700;
          padding: 15px 0;"
          >
        <a href="https://booking-2491e.firebaseapp.com/cancel" width="240" height="50" href="#" style="color: #ffffff;text-decoration: none;margin: 0 auto 30px;">Cancelar reserva</a>
      </td>
      <td width="180"></td>
    </tr>
    <tr>
      <td colspan="3" width="100%" style="width: 100%; padding: 30px 0">
        <p style="margin: 0 0 3px 0;">Gracias</p>
        <p style="margin: 0 0 20px 0;">El equipo Booking-Restaurant</p>
      </td>
    </tr>
  </table>
</body>
</html>', 'PAYMENT');



INSERT INTO `BOOKING_RESTAURANT`.`NOTIFICATION` (`ID`, `TEMPLATE`, `TEMPLATE_TYPE`) VALUES 
(2, '<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <title>Booking</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>
<body style="margin: 0; padding: 0;">
  <table align="center" border="0" cellpadding="0" cellspacing="0" width="400" style="border-collapse: collapse;font-family: Arial, sans-serif; font-size: 16px; color: #9b9b9b; max-width: 600px;">
    <tr>
      <td colspan="3" width="100%" style="text-align: left;padding: 0 0 30px 0; width: 100%;">
          <img src="https://www.publicdomainpictures.net/pictures/270000/velka/restaurant-reservation-food-cus.jpg" height="230" width="100%" alt="">
      </td>
    </tr>
    <tr>
      <td colspan="3" width="100%" style="width: 100%;">
        <p style="margin: 0 0 20px 0;">Hola {name}</p>
        <p style="margin: 0 0 20px 0;"><b>Has cancelado tu reserva con éxito.</b> A continuación puedes realizar una nueva reserva.</p>
        <p style="margin: 0 0 30px 0;"></p>
      </td>
    </tr>
    <tr>
      <td width="180"></td>
      <td bgcolor="#7eb548" width="240px" style="text-align: center;
          width: 240px;
          display: block;
          border: 1px solid transparent;
          border-radius: 2px;
          font-weight: 700;
          padding: 15px 0;"
          >
        <a href="https://booking-2491e.firebaseapp.com/" width="240" height="50" href="#" style="color: #ffffff;text-decoration: none;margin: 0 auto 30px;">Reservar</a>
      </td>
      <td width="180"></td>
    </tr>
    <tr>
      <td colspan="3" width="100%" style="width: 100%; padding: 30px 0">
        <p style="margin: 0 0 3px 0;">Gracias</p>
        <p style="margin: 0 0 20px 0;">El equipo Booking-Restaurant</p>
      </td>
    </tr>
  </table>
</body>
</html>', 'CANCEL');



INSERT INTO `BOOKING_RESTAURANT`.`NOTIFICATION` (`ID`, `TEMPLATE`, `TEMPLATE_TYPE`) VALUES 
(3, '<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <title>Booking</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>
<body style="margin: 0; padding: 0;">
  <table align="center" border="0" cellpadding="0" cellspacing="0" width="400" style="border-collapse: collapse;font-family: Arial, sans-serif; font-size: 16px; color: #9b9b9b; max-width: 600px;">
    <tr>
      <td colspan="3" width="100%" style="text-align: left;padding: 0 0 30px 0; width: 100%;">
          <img src="https://www.publicdomainpictures.net/pictures/270000/velka/restaurant-reservation-food-cus.jpg" height="230" width="100%" alt="">
      </td>
    </tr>
    <tr>
      <td colspan="3" width="100%" style="width: 100%;">
        <p style="margin: 0 0 20px 0;">Hola {name}</p>
        <p style="margin: 0 0 20px 0;"><b>Has realizado tu reserva correctamente</b>. En caso de que no puedas acudir debes cancelar la reserva lo antes posible</p>
        <p style="margin: 0 0 30px 0;"></p>
      </td>
    </tr>
    <tr>
      <td width="180"></td>
      <td bgcolor="#c90c0c" width="240px" style="text-align: center;
          width: 240px;
          display: block;
          border: 1px solid transparent;
          border-radius: 2px;
          font-weight: 700;
          padding: 15px 0;"
          >
        <a href="https://booking-2491e.firebaseapp.com/cancel" width="240" height="50" href="#" style="color: #ffffff;text-decoration: none;margin: 0 auto 30px;">Cancelar reserva</a>
      </td>
      <td width="180"></td>
    </tr>
    <tr>
      <td colspan="3" width="100%" style="width: 100%; padding: 30px 0">
        <p style="margin: 0 0 3px 0;">Gracias</p>
        <p style="margin: 0 0 20px 0;">El equipo Booking-Restaurant</p>
      </td>
    </tr>
  </table>
</body>
</html>', 'RESERVATION');





